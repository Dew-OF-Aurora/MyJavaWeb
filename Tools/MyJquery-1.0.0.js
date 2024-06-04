function Jquery(selector) {
    //属于构造方法体,传入一个domid,取得该dom元素对象
    if (typeof selector == "string") {
        //输入ID选择器
        if (selector.charAt(0) === "#"){
            //定义取得dom元素为全局变量,拿到元素
            domobj = document.getElementById(selector.substring(1));
            return new Jquery()
        }
    }
    //属于构造方法体, 将会在使用jq类的时候判断
    if(typeof selector === "function"){
        window.onload = selector
    }
    //内置方法,向dom元素对象中传递一段属性
    this.html = function (htmlstr){
        domobj.innerHTML = htmlstr
    }
    //内置方法, 向dom元素的某个事件句柄传递一段function(){}
    this.click = function (fun) {
        domobj.onclick = fun
    }
    this.val = function (value){
        if (typeof value == "string"){
            domobj.value = value
        }
        return domobj.value
    }
    //静态方法,转换为URL
    Jquery.json2url = function(json) {
        return Object.keys(json).map(key => key + '=' + json[key]).join('&');
    }

    /**
     * 静态方法
     * 传入的JSON数据
     *     type:"POST",
     *     url:"",
     *     async:"true",
     *     data:"JSON对象"
     *     success:function(json){成功返回的json对象数组}
     * @param Args
     */
    Jquery.ajax = function (Args){
        var xhr = new XMLHttpRequest()
        xhr.onreadystatechange = function (){
            if (this.readyState === 4) {
                if (this.status === 200) {
                    var respJsonObj = JSON.parse(this.responseText)
                    Args.success(respJsonObj)
                }
            }
        }
        if (Args.type.toUpperCase() === "POST"){
            xhr.open("POST",Args.url,Args.async)
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            xhr.send(this.json2url(Args.data))
        }
        if (Args.type.toUpperCase() === "GET"){
            console.log(Jquery.json2url(Args.data).toString())
            xhr.open("GET",Args.url+"?"+this.json2url(Args.data),Args.async)
            xhr.send()
        }
    }
}
$ = Jquery
//为了让静态函数生效
new Jquery()