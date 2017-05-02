<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>阅读论坛</title>
    <meta name="description" content="app, web app, responsive, responsive layout, admin, admin panel, admin dashboard, flat, flat ui, ui kit, AngularJS, ui route, charts, widgets, components" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
</head>
<body>
<div id="sample">
    <script type="text/javascript" src="<%=request.getContextPath()%>/media/js/nicEdit/nicEdit.js"></script>
    <script type="text/javascript">
        bkLib.onDomLoaded(function () {
            nicEditors.allTextAreas()
        });
    </script>

    <h4>First Textarea</h4>
    <textarea name="area1" cols="40"></textarea>
    <br/>

    <h4>Second Textarea</h4>
    <textarea name="area2" style="width: 100%;">
	Some Initial Content was in this textarea
</textarea>
    <br/>

    <h4>Third Textarea</h4>
    <textarea name="area3" style="width: 300px; height: 100px;">
	HTML <b>content</b> <i>default</i> in textarea
</textarea>
</div>

</body>
</html>