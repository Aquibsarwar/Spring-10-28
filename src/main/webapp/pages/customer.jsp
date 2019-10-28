<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ja-jp"/>
<head>
	<meta charset="UTF-8">
</head>
<form method="post" action="details">
  <fieldset>
    
    <h1><legend>Personal information インフォメーション:</legend></h1>
    
    customer 名前:<br>
    <h3><input type="text" name="cname" value=""><br></h3>
    customer ID:<br>
    <h3><input type="text" name="cid" value=""><br></h3>
    customer メイル:<br>
    <h3><input type="text" name="cemail" value=""><br><br></h3>
    
    <input type="submit" value="Submit">
  </fieldset>
</form>
</html>