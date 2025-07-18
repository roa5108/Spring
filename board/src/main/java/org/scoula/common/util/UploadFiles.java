package org.scoula.common.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class UploadFiles {
    public static String upload(String baseDir, MultipartFile part) throws IOException {
        // 기본 디렉토리가 있는지 확인, 없으면 새로 생성
        File base = new File(baseDir);
        if(!base.exists()) {
            base.mkdirs(); // 중간에존재하지않는디렉토리까지모두생성
        }

        String fileName = part.getOriginalFilename();
        File dest = new File(baseDir, UploadFileName.getUniqueName(fileName));

        part.transferTo(dest);
        return dest.getPath();
    }

    public static String getFormatSize(Long size){
        if(size<=0) return "0";
        final String[] units = new String[]{"Bytes", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
        return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
    }

    public static void download(HttpServletResponse response, File file, String orgName) throws Exception {
        response.setContentType("application/download");
        response.setContentLength((int) file.length());

        String filename = URLEncoder.encode(orgName, "UTF-8");
        response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"");

        try(OutputStream os = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os)){
            Files.copy(Paths.get(file.getPath()), bos);
        }
    }
}
