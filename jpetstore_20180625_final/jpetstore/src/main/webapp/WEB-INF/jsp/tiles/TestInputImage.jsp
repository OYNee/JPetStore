<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> <html> <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>이미지 업로드</title> </head> 
 <body> 
  <form method="POST" action="uploadFile.do" enctype="multipart/form-data">
 	<input type="file" name="files">
 	<input type="submit" value="업로드" />
 </form>
