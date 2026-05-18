package com.example.cms.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/user/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, 
                         HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("file");
        if (name == null || name.contains("..")){
            resp.sendError(400);
            return;
        }
        File f = new File("C:/app-files", name);
        if(!f.exists()){
            resp.sendError(400);
            return;
        }

        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition",
            "attachment; filename=\"" + name + "\"");

            try (InputStream in = new FileInputStream(f);
            OutputStream out = resp.getOutputStream()){
                byte[] buf = new byte[4096];
                int len;
                while ((len = in.read(buf)) != -1) {
                    out.write(buf,0,len);
            }
         }
    }
}