package WebAssess.web.UI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListFileServlet
 */
@WebServlet("/ListFileServlet")
public class ListFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFileServlet() {
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
		// TODO Auto-generated method stub
		String uploadFilePath=this.getServletContext().getRealPath("/WEB-INF/upload");
		Map<String,String> fileNameMap = new HashMap<String,String>();
	    listfile(new File(uploadFilePath),fileNameMap);
	    request.setAttribute("fileNameMap", fileNameMap);
	    request.getRequestDispatcher("/WEB-INF/pages/listfile.jsp").forward(request,response);
	}

	private void listfile(File file, Map<String, String> map) {
		// TODO Auto-generated method stub
		if(!file.isFile()){
			File files[]=file.listFiles();
			for(File f : files){
				listfile(f,map);
			}
		}else{
			String realName=file.getName().substring(file.getName().indexOf("_")+1);
			map.put(file.getName(), realName);
			
		}
	}

}
