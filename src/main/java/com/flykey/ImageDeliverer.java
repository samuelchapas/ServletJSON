package com.flykey;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;

/**
 * Servlet implementation class ImageDeliverer
 */

public class ImageDeliverer extends HttpServlet {
	
	private final static Logger LOGGER = Logger.getLogger(QueryUtils.class.getCanonicalName());

    /** Tag for the log messages */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();
    private static List<String> subString = new ArrayList<String>();
	private static int subStringChar = 100;
	
	private static final long serialVersionUID = 1L;
	private static final String REQUEST_URL =
			 "sleepy-coast-43676.herokuapp.com"; 
	/*
	private static final String REQUEST_URL =
			 "localhost";
	*/
	private static final String SCHEME_URL =
			 "https";
	/*
	private static final String SCHEME_URL =
			 "http";
			 
			*/
	
	//private static final String PATH_URL =
	//		 "SearchServlet";
	
	private static final String PATH_URL =
					 "SearchServlet";
	
	/*
	private static final String PATH_URL =
			 "FlykeyWebApp/SearchServlet";
	*/
	
	private String imagen = "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";
	
	private List<String> parameters = new ArrayList<String>();
	private List<String> values = new ArrayList<String>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDeliverer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath() + "by PostMethod");
		StringBuilder subStringOnParts = new StringBuilder();
		//response.setContentType("text/html");
		response.setContentType("application/json");
		//request.setCharacterEncoding("latin1");
        
		int index = 0;
        
        for(int i = 0; i < imagen.length() ; i++) {
        	
        	subStringOnParts.append(imagen.charAt(i));
        	
        	index++;
        	
        	if(index + 1 == subStringChar || imagen.length() == (i + 1)) {
        		//String newText = subStringOnParts.toString();
        		//System.out.println("Trial " + newText);
        		//I take this from the segmenting String
        		subString.add(subStringOnParts.toString());

                index = 0;
        		subStringOnParts = new StringBuilder();
        	} 
        }
        
		parameters.add("name");
        parameters.add("apikey");//this is mnot saved on database
        //parameters.add("base64");
        
        parameters.add("command"); //command is not saved on database
        parameters.add("user");
        parameters.add("description");
        
        parameters.add("tag");
        parameters.add("settingService");
        parameters.add("quantity");
        parameters.add("date");
        
        parameters.add("specialCode");
        parameters.add("partTotal");
        //parameters.add("part");
        
        values.add("FlyKey");
        values.add("iofindiofnciserf");
        //values.add(subStringOnParts.toString());
		
        //values.add("FlyKeyWebAPP");
        values.add("add");
        values.add("admin");
        values.add("This is the logo for the FlyKey Keyboard Company");
        
        values.add("keyboard FlyKey");
        values.add("PFR");
        values.add("80000");
        values.add("2018:01:04 05:49:36");
        
        values.add(imagen.substring(subStringChar, subStringChar + 25));
        values.add(String.valueOf(subString.size()));
        //values.add("part");
        
        //UriBuilder builder = UriBuilder.fromPath(PATH_URL).scheme(SCHEME_URL).host(REQUEST_URL).port(8085);
        
        for(int t = 0; t < subString.size(); t++) {
        	parameters.add("base64");
        	parameters.add("part");
        	
        	values.add(subString.get(t));
        	values.add(String.valueOf(t) + 1);
        	
        	UriBuilder builder = UriBuilder.fromPath(PATH_URL).scheme(SCHEME_URL).host(REQUEST_URL);
        	
		    for(int j = 0; j < parameters.size(); j++) {
		        builder.queryParam(parameters.get(j), values.get(j));
		        //builder.queryParam("apikey", "hola");
		        //builder.queryParam("base64", "hola");
		        //builder.queryParam("command", "hola");
		        //builder.queryParam("user", "hola");
		        //builder.queryParam("description", "hola");
		        //builder.queryParam("tag", "hola");
		        //builder.queryParam("settingService", "hola");
		        //builder.queryParam("quantity", "hola");
		    	//if(request.getParameter(parameters.get(i)) == null) {
		    		//empty.concat(request.getParameter(parameters.get(i)).toString() + ", " );
		    	//}
		
		    }
		    
		    URI baseUri = builder.build();
		    //URI.Builder uriBuilder = baseUri.buildUpon();
		    
		    //uriBuilder.appendQueryParameter("format", "geojson");
		    //uriBuilder.appendQueryParameter("limit", "10");
		    //uriBuilder.appendQueryParameter("minmag", minMagnitude);
		    //uriBuilder.appendQueryParameter("orderby", orderBy);
		
		    //return new EarthquakeLoader(this, uriBuilder.toString());
		    //response.getWriter().append("Served at: ").append(request.getContextPath() + 
		    //		"by PostMethod and Uri" + baseUri.toString());
		    
		    LOGGER.warning(LOG_TAG + " " + baseUri.toString());
		    
		    QueryUtils.fetchEarthquakeData(baseUri.toString());
		    
		    int parametersToRemove = values.size();
		    
		    values.remove(parametersToRemove - 1);
		    values.remove(parametersToRemove - 2);
		    
		    parameters.remove(parametersToRemove - 1);
		    parameters.remove(parametersToRemove - 2);
        } 
        //File file = new File
        //for(File fileLucene:file.listFiles()) {
		//	files.add(fileLucene.toString());
		//}
        Set<String> values = getServletContext().getResourcePaths("/");
        Iterator<String> value = values.iterator();
        
        List<String> valueFile = new ArrayList<String>();
        
        while(value.hasNext()) {
        	
        	valueFile.add(value.next());
        	
        }
        
        String contextPath = getServletContext().getRealPath("/");

        String luceneFilePath = contextPath + "/WEB-INF";

        //System.out.println(xmlFilePath);
        
        File myfile = new File(luceneFilePath);
        //myfile.mkdir();
        //myfile.createNewFile();
        List<String> another = new ArrayList<String>();
        
        for(String take: myfile.list()) {
        	another.add(take);
        }
        
        response.getWriter().append("Served at: ").append(request.getContextPath() + 
                		" by PostMethod and Uri " + " " + another.toString());
	}

}
