package WebAssess.web.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileupload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//得到上传文件的保存目录，将上传文件存放到web-inf目录下，不允许直接访问
		String savepath=this.getServletContext().getRealPath("/WEB-INF/upload");
		//上传时生成的临时文件保存目录
		String temppath=this.getServletContext().getRealPath("/WEB-INF/temp");
		File tempfile =new File(temppath);
		//判断文件是否存在
		if(!tempfile.exists()){
			System.out.println(temppath+"目录不存在，需要创建");
		    tempfile.mkdir();
		}
		//消息提醒
		String message = "";
		//使用Apache文件组件处理文件的上传步骤
		try{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1024*100);
			//设置上传时生成的临时文件的保存目录
			factory.setRepository(tempfile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			//监听文件上传进度
			upload.setProgressListener(new ProgressListener(){
				 public void update(long pBytesRead,long pContentLength,int arg2){
					System.out.println("文件大小为："+pContentLength+",当前已处理："+pBytesRead); 
				 } 
			});
			upload.setHeaderEncoding("utf-8");
			if(!ServletFileUpload.isMultipartContent(request)){
				return;
			}
			//设置上传单个文件的大小的最大值。目前是设置为1024*1024字节，也就是1mb
			upload.setFileSizeMax(1024*1024*8);
			//设置上传文件总量的最大值 ，
			upload.setSizeMax(1024*1024*100);
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
			  //如果fileitem中封装得是普通输入项的数据
				if(item.isFormField()){
					String name=item.getFieldName();
					String value=item.getString("utf-8");
					System.out.println(name+"="+value);
				}else {
					//如果fileitem中封装的是上传文件
					//得到上传文件的名称
					String filename = item.getName();
					System.out.println(filename);
					if(filename == null || filename.trim().equals("")){
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					//得到上传文件的扩展名
					String fileExtName =filename.substring(filename.lastIndexOf(".")+1);
					System.out.println("上传文件的扩展名是："+fileExtName);
					if(fileExtName.equals("zip")||fileExtName.equals("txt")){
				    InputStream in=item.getInputStream();
				    //得到文间保存的名称
				    String saveFilename=makeFileName(filename);
				    String realSavePath=makePath(saveFilename,savepath);
				    FileOutputStream out =new FileOutputStream(realSavePath+"\\"+saveFilename); 
				    byte buffer[] =new byte[1024];
				    int len=0;
				    while((len=in.read(buffer))>0){
				    	out.write(buffer,0,len);
				    }
				    in.close();
				    out.close();
				    item.delete();
				    message="文件上传成功！";
				}else{
					message="文件格式不正确上传文件失败！！";
				}
			}
			}
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			e.printStackTrace();
			request.setAttribute("message","单个文件超出最大值!!!");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
			return ;
		}catch(FileUploadBase.SizeLimitExceededException e){
			e.printStackTrace();
			request.setAttribute("message", "上传文件的总的大小超出限制的额最大值！！");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
			return ;
		}catch(Exception e){
			message="文件上传失败！";
		}
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public String makePath(String filename, String savepath) {
		// TODO Auto-generated method stub
		int hashcode =filename.hashCode();
		int dir1=hashcode&0xf;
		int dir2=(hashcode&0xf0)>>4;
		String dir=savepath+"\\"+dir1+"\\"+dir2;
		File file = new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
		return dir;
		
	}

	private String makeFileName(String filename){ //2.jpg
		  //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
		  return UUID.randomUUID().toString() + "_" + filename;
		 }  
}
