<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="ajax" id="btn" />
<table border="1px">
    <tr>
        <td>
            用户名
        </td>
        <td>
            密码
        </td>
    </tr>
    <tbody id="tbdoy"></tbody>
</table>

</div>
</body>
</html>
<script>
    document.getElementById("btn").onclick = function (){
        var xmlHttpRequest = new XMLHttpRequest();
        //状态码改变时运行该函数
        xmlHttpRequest.onreadystatechange = function (){
            //console.log(xmlHttpRequest.readyState)
            if(this.readyState === 4){
                if (this.status === 404){
                    alert("资源不存在")
                }
                if (this.status === 200){
                    //接受响应
                    //document.getElementById("mydiv").innerText = this.responseText
                    var fromJavaJson = JSON.parse(this.responseText)
                    var html = ""
                    for (var i = 0 ;i < fromJavaJson.length;i++){
                        html += "<tr>"
                        html += "<td>"+fromJavaJson[i].name+"</td>"
                        html += "<td>"+fromJavaJson[i].passwd+"</td>"
                        html += "<tr>"
                    }
                    document.getElementById("tbdoy").innerHTML = html
                }
            }
        }
        //发送get请求
        xmlHttpRequest.open("GET","${pageContext.request.contextPath}/ajax/request",true)
        xmlHttpRequest.send()
    }
</script>

