<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>全国法院被执行人信息查询 - 被执行人查询</title>
    <link href="http://zhixing.court.gov.cn/search/static/style/style.css?v=20130408" type="text/css" rel="stylesheet" media="screen, projection" />
    <link href="http://zhixing.court.gov.cn/search/static/style/jquery-ui.min.css" type="text/css" rel="stylesheet" media="screen, projection" />
    <script language="javascript" type="text/javascript" src="http://zhixing.court.gov.cn/search/static/javascript/jquery-latest.js"></script>
    <script language="javascript" type="text/javascript" src="http://zhixing.court.gov.cn/search/static/javascript/jquery-ui.min.js"></script>
    <script language="javascript" type="text/javascript" src="http://zhixing.court.gov.cn/search/static/javascript/data.js"></script>
    <script language="javascript" type="text/javascript" src="http://zhixing.court.gov.cn/search/static/javascript/index.js"></script>
    <script language="javascript" type="text/javascript" src="http://zhixing.court.gov.cn/search/static/javascript/courtSelect.js"></script>
    <script>
//         var contextPath = '';
//         var _gaq = _gaq || [];
//         _gaq.push(['_setAccount', 'UA-32892685-2']);
//         _gaq.push(['_trackPageview']);

//         (function() {
//             var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
//             ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
//             var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
//         })();


    

        if   (top.location   !=self.location)top.location=self.location;
       
    </script>
    <script type='text/javascript' src='http://yhxwfx.court.gov.cn/910005/gs.js'></script>  
	<script language="javascript" type="text/javascript">
	var captchaId = '65dd32d5b7d04d35820a0a231d14f985';
	function refreshCaptcha() {
		$('#captchaImg').attr('src','http://zhixing.court.gov.cn/search/captcha.do?captchaId=' +captchaId+'&random='+Math.random());
	}
	 
	
</script>
<style>
 .middle_top_form #ymbutton {
	width: 93px;
	height: 33px;
	border: 0px;
	background: url(http://zhixing.court.gov.cn/search/images/t_middle_top_form_button.jpg) no-repeat;
	cursor: pointer;
}
 .middle_top_form {
	margin-left: 274px;
	padding-top: 67px;
	width: 340px;
}
 
#searchForm input {
	    margin-left: -250px;
	    margin-top: -4px;
	    height: 26px;
}
.t_middle_top_select_button{
text-align: left;
}
</style> 	
</head>
<body>
<div class="temp">
    <div class="top">
    </div>
    <div class="bannar">
        <img src="http://zhixing.court.gov.cn/search/static/images/t_bannar.jpg" border="0" usemap="#Map3" />
        <map name="Map3" id="Map3">
            <area shape="rect" coords="30,80,123,110" href="http://www.court.gov.cn/" />
        </map>
    </div>
    <!-- 中部 -->
    <div class="middle">

        <!-- 查询条件 -->
        <div class="middle_top"  >
            <div class="middle_top_form">
               <form id="searchForm" action="http://zhixing.court.gov.cn/search/newsearch" method="post" target="contentFrame">
                    <input type="hidden" id="searchCourtName" name="searchCourtName" value="全国法院（包含地方各级法院）"/>
                    <input type="hidden" id="selectCourtId" name="selectCourtId" value="1"/>
                    <input type="hidden" id="selectCourtArrange" name="selectCourtArrange" value="1"/>
                    <table width="550" border="0" cellspacing="0" cellpadding="0" style="text-align: left;">
                        <tr style="text-align: center;">
                            <td height="35"><input type="text" id="pname" name="pname" onchange="refreshCaptcha()"></td>
                        </tr>
                        <tr style="text-align: center;">
                            <td height="35"><input type="text" id="cardNum" name="cardNum" onchange="refreshCaptcha()"></td>
                        </tr>
                        <tr>
                            <td height="36">
                                <div id="courtName" class="t_middle_top_select_button">全国法院（包含地方各级法院）</div>
                                <div style="position: relative;">
                                    <div class="t_middle_top_select_block" id="SelectBlock">
                                        <div class="t_middle_top_select_block_top"></div>
                                        <div class="t_middle_top_select_block_middle">
                                            <ul id="count_senior" style="height: 300px;">
                                                <div style="clear: both;">
                                                    <li><a href="javascript:void(0)" arrange="true" arrangeValue="1" class="active"  onclick="selectItem(1)">全国法院（包含地方各级法院）</a></li>
                                                    <li><a href="javascript:void(0)" arrange="true" arrangeValue="4" onclick="selectItem(0)">最高人民法院（不包含地方各级法院）</a></li>
                                                </div>
                                                <div id="selectContent" style="clear: both; border-top: 2px #b01504 solid;height: 270px;overflow: auto;">
                                                </div>
                                            </ul>
                                            <ul id="court_middle">
                                                <div style="clear: both;">
                                                    <li><a href="javascript:void(0)" arrange="true" arrangeValue="2" class="active"><span name="court_name"></span>（包含辖区法院）</a></li>
                                                    <li><a href="javascript:void(0)" arrange="true" arrangeValue="4"><span name="court_name"></span>（不包含辖区法院）</a></li>
                                                </div>
                                                <div id="selectContent" style="clear: both; border-top: 2px #b01504 solid;">
                                                </div>
                                            </ul>
                                            <ul id="court_basic" >
                                                <div style="clear: both;">
                                                    <li><a href="javascript:void(0)" arrange="true" arrangeValue="3" class="active"><span name="court_name"></span>（包含辖区法院）</a></li>
                                                    <li><a href="javascript:void(0)" arrange="true" arrangeValue="4"><span name="court_name"></span>（不包含辖区法院）</a></li>
                                                </div>
                                                <div id="selectContent" style="clear: both; border-top: 2px #b01504 solid;">
                                                </div>
                                            </ul>
                                            <div style="clear: both; padding: 6px; text-align: center; width: 500px;">
                                                <button id="lastSelect" type="button">&nbsp;&nbsp;上一步&nbsp;&nbsp;</button>
                                                <button id="SelectCourtOk" type="button">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>
                                                <button id="SelectCourtCancel" type="button">&nbsp;&nbsp;关闭&nbsp;&nbsp;</button>
                                            </div>
                                        </div>
                                        <div class="t_middle_top_select_block_bottom"></div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr style="text-align: center;">

                            <td height="35"><input type="text" id="j_captcha" name="j_captcha"  style="width:170px">
                            <img id="captchaImg" src="http://zhixing.court.gov.cn/search/captcha.do?captchaId=65dd32d5b7d04d35820a0a231d14f985&random=0.3824029820912018" onclick="this.src='http://zhixing.court.gov.cn/search/captcha.do?captchaId=65dd32d5b7d04d35820a0a231d14f985&random=0.1425963450595279'"style=" height:28px;margin-top: -4px;position: absolute;"/>
                                <span style="margin-left:90px; "><a href="javascript:void(0)" onclick="refreshCaptcha();" style="font-weight: bold;">换一张</a></span></td>
                        </tr>
                        <tr style="text-align: center;">
                            <td height="38">
                                <button id="ymbutton" type="button" onclick="search();" style="background: url('http://zhixing.court.gov.cn/search/static/images/t_middle_top_form_button.jpg') no-repeat;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                                <button id="returnButton" onclick="returnIndex();" style="margin-left:10px;display: none" type="button">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                            </td>
                        </tr>
                    </table>
                 <input id="captchaId" name="captchaId" type="hidden" value="65dd32d5b7d04d35820a0a231d14f985"/>
                 <input type="hidden" value="" id="gskeyword"></input>
                </form>   		           
               </div> 
        </div>

        
            <iframe src="http://zhixing.court.gov.cn/search/newsearch?searchCourtName=%E5%85%A8%E5%9B%BD%E6%B3%95%E9%99%A2%EF%BC%88%E5%8C%85%E5%90%AB%E5%9C%B0%E6%96%B9%E5%90%84%E7%BA%A7%E6%B3%95%E9%99%A2%EF%BC%89&selectCourtId=1&selectCourtArrange=1&pname=%E8%A2%81%E6%9C%AC%E5%8D%B0&cardNum=422727197303063878&j_captcha=euza&captchaId=55804cc44e5d4a4fbdfea24dd81154a9" style="width:100%;height:471px;border: 0px;" scrolling="no" id="contentFrame" name="contentFrame"></iframe>
        </div>
        <!--- 底部 -->

        <div class="bottom">
            <div class="link1">
                <a href="http://cpc.people.com.cn/" target='_blank' style="font-size: 12px;">中国共产党新闻</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
                    href="http://www.npc.gov.cn/" target='_blank' style="font-size: 12px;">全国人大</a> &nbsp;&nbsp;&nbsp;&nbsp;<a
                    href="http://www.gov.cn/" target='_blank' style="font-size: 12px;">中国政府网</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="http://www.cppcc.gov.cn" target='_blank' style="font-size: 12px;">全国政协</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
                    href="http://www.spp.gov.cn" target='_blank' style="font-size: 12px;">最高人民检察院</a>
            </div>
            <div class="link2" style="font-size: 12px;">
                <a href="http://mail.court.gov.cn/"style="font-size: 12px;">内部邮箱</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                    href="./gywm/" style="font-size: 12px;">关于我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="./wzdt/" style="font-size: 12px;">网站地图</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a
                    href="javascript:window.external.AddFavorite('http://www.court.gov.cn','中华人民共和国最高人民法院')"
                    target="_top" style="font-size: 12px;">添加收藏</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href=""
                                                                      onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://www.court.gov.cn');"
                                                                      title=设置本站为浏览器首页(起始页) style="font-size: 12px;">设为首页</a><br /> 中华人民共和国最高人民法院版权所有<br />
                北京市东城区东交民巷27号 100745 总机:67550114 举报:67556131<br /> 京ICP备05023036号
            </div>
        </div>

    </div>

    <map name="Map" id="Map">
        <area shape="rect" coords="650,36,973,64" href="javascript:void(0)" />
    </map>

    <map name="Map2" id="Map2">
        <area shape="rect" coords="41,1,210,22" href="javascript:void(0)" />
    </map>
   <!--  <div id='valideCode' title="请输入验证码" style="display: none">	
	 <input type="text" id="j_captchad" name="j_captcha"  style="width:75px"/>
	 <img id="captchaImgd" src="" style=" height:30px;margin-left:5px;position: absolute;"/>
     <span style="margin-left:80px; ">
     <a href="javascript:void(0)" onclick="refreshCaptchad();" style="font-weight: bold;">换一张</a>
     </span>
     </div>	 -->	
    
   
</body>
</html>
