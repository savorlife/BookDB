package com.systop.util;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @Author: REN
 * @Description:
 * @Date: Created in 23:09 2018/3/15
 */
public class UploadUtil {
    private static final long serialVersionUID = 1L;

    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    // 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 200; // 200MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 1000; // 1000MB

    /**
     * 上传数据及保存文件
     */
    public static HashMap upload(HttpServletRequest request) throws ServletException, IOException {

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        //设置多媒体文件参数
        HashMap<String, String> map = new HashMap<String, String>();


        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("") +  UPLOAD_DIRECTORY + File.separator;

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // 解析请求的内容提取文件数据
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();// 遍历表单中提交过来的内容
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
                    String value = item.getString("UTF-8"); // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
                    String name = item.getFieldName();
                    map.put(name, value);
                }else {
                	//真正把图片上传到服务器的代码
                    String type = item.getFieldName();
                    String fileName = UUID.randomUUID().toString()+".jpg";//随机生成名字
      
                    String filePath = uploadPath + fileName;
                    File storeFile = new File(filePath);
                    // 在控制台输出文件的上传路径
                    String url = request.getContextPath()+"/"+UPLOAD_DIRECTORY+"/"+fileName;
                    map.put(type, url);
                    // 保存文件到硬盘
                    item.write(storeFile);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }
}