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

    // �ϴ��ļ��洢Ŀ¼
    private static final String UPLOAD_DIRECTORY = "upload";

    // �ϴ�����
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 200; // 200MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 1000; // 1000MB

    /**
     * �ϴ����ݼ������ļ�
     */
    public static HashMap upload(HttpServletRequest request) throws ServletException, IOException {

        // �����ϴ�����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // �����ڴ��ٽ�ֵ - �����󽫲�����ʱ�ļ����洢����ʱĿ¼��
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // ������ʱ�洢Ŀ¼
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // ��������ļ��ϴ�ֵ
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // �����������ֵ (�����ļ��ͱ�����)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // ���Ĵ���
        upload.setHeaderEncoding("UTF-8");

        //���ö�ý���ļ�����
        HashMap<String, String> map = new HashMap<String, String>();


        // ������ʱ·�����洢�ϴ����ļ�
        // ���·����Ե�ǰӦ�õ�Ŀ¼
        String uploadPath = request.getServletContext().getRealPath("") +  UPLOAD_DIRECTORY + File.separator;

        // ���Ŀ¼�������򴴽�
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        try {
            // ���������������ȡ�ļ�����
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();// ���������ύ����������
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) { // ����Ǳ��� �����Ƿ��ļ��ϴ�Ԫ��
                    String value = item.getString("UTF-8"); // ��ȡvalue���Ե�ֵ��������Ҫָ��UTF-8��ʽ���������������������
                    String name = item.getFieldName();
                    map.put(name, value);
                }else {
                	//������ͼƬ�ϴ����������Ĵ���
                    String type = item.getFieldName();
                    String fileName = UUID.randomUUID().toString()+".jpg";//�����������
      
                    String filePath = uploadPath + fileName;
                    File storeFile = new File(filePath);
                    // �ڿ���̨����ļ����ϴ�·��
                    String url = request.getContextPath()+"/"+UPLOAD_DIRECTORY+"/"+fileName;
                    map.put(type, url);
                    // �����ļ���Ӳ��
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