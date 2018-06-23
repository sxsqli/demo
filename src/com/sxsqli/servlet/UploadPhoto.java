package com.sxsqli.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sxsqli.domain.User;

/**
 * Servlet implementation class UploadPhoto
 */
public class UploadPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			response.getWriter().println("<h1>拒接访问</h1>");
		}
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileItems = servletFileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems) {
				String photoName = fileItem.getName();
				System.out.println(fileItem.getContentType());
				if (!fileItem.isFormField() && fileItem.getSize() > 0) {
					photoName = photoName.substring(photoName.lastIndexOf("\\") + 1);

					File path = new File(getServletContext().getRealPath("/img/photo"));
					File photo = new File(path, photoName);
					if (!path.exists()) {
						path.mkdirs();
					} else {
						for (int i = 1; photo.exists(); i++) {
							photo = new File(path, "(" + i + ")" + photoName);
						}
					}

					fileItem.write(photo);

					((User) request.getSession().getAttribute("user")).setPhotoPath("img/photo/" + photoName);
					response.getWriter().println("<h1>" + photoName + "上传成功</h1>");
				} else {
					response.getWriter().println("<h1>" + photoName + "上传失败</h1>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			response.getWriter().println("<a href='index.jsp'>返回首页</a>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
