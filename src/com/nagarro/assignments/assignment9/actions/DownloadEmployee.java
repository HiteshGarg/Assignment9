/**
 * 
 */
package com.nagarro.assignments.assignment9.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.assignments.assignment9.services.EmployeeManagaer;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hiteshgarg
 * 
 */
@InterceptorRef(value="customInterceptorStack")
public class DownloadEmployee extends ActionSupport {

	/**
	 * Serial version Uid.
	 */
	private static final long serialVersionUID = 4982892701899332660L;

	/**
	 * Complete path of the file created in temporary folder.
	 */
	private String fileName;

	/**
	 * FileInput Stream.
	 */
	private InputStream fileInputStream;

	@Override
	@Action(results = { @Result(name = "success", location = "admin-home", type = "stream", params = {
			"contentType", "application/octet-stream", "inputName",
			"fileInputStream", "contentDisposition", "filename=${fileName}",
			"bufferSize", "1024" })})
	public String execute() throws Exception {
		String fileUrl = new EmployeeManagaer().downloadEmployeeList();
		fileName = fileUrl.substring(fileUrl.lastIndexOf("\\") + 1);
		System.out.println(fileName);
		fileInputStream = new FileInputStream(new File(fileUrl));
		return SUCCESS;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileInputStream
	 */
	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	/**
	 * @param fileInputStream
	 *            the fileInputStream to set
	 */
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

}
