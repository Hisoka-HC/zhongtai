var domin = 'http://59.110.158.100/sdw/';
var login = function(data){
};

var post = function(url, data,callback, error){
  var index = layer.load(1,{shade: [0.3,'#000']});
  console.log(domin + url)
  console.log(data)
  $.ajax({
    url: domin + url,
    data: data,
    type: 'post',
    xhrFields:{
      withCredentials: true
    },
    crossDomain: true,
    success(res){
      layer.close(index);
      console.log(res);
      if(res == 'failed'){
        var href = window.location.href;
        if(href.indexOf('login.html') == -1){
          window.location.href = 'login.html?ref=' + href;
        }else{
          layer.msg('用户名或密码错误，请重新登录');
          return 
        }
      }else{
        layer.msg(res);
      }
      callback(res);
    }
  })
};
var get = function(url, data, callback){
  var index = layer.load(1,{shade: [0.3,'#000']});
  $.ajax({
    url: domin + url,
    data: data,
    type: 'get',
    xhrFields:{
      withCredentials: true
    },
    crossDomain: true,
    success(res){
      layer.close(index);
      if(res == 'failed'){
        var href = window.location.href;
        if(href.indexOf('login.html') == -1){
          window.location.href = 'login.html?ref=' + href;
        }else{
          return
        }
      };
      callback(res);
    }
  })
};
var getUrlParam = function(name){
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURIComponent(r[2]); return null;
};


function delHtmlTag(str)
{
  var str=str.replace(/<\/?[^>]*>/gim,"");//去掉所有的html标记
  var result=str.replace(/(^\s+)|(\s+$)/g,"");//去掉前后空格
  return  result.replace(/\s/g,"");//去除文章中间空格
}

function phoneTest(phone){
  if(!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(phone))){
    layer.msg('请输入正确的电话号码');
    $('#phone').val('').focus();
    return true
  }else{
    return false
  }
};

function isCardNo(card) { 
  // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X 
  var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
  if(reg.test(card) === false) { 
    layer.msg('请输入正确的身份证号码');
    return true; 
  } else{
    return false; 
  }
};

function page(size){
  var pageSize = Math.ceil(size / 10);
  var arr = [];
  for(var i = 1; i <= pageSize; i++){
    if(i == 1){
      arr.push({
        page: i,
        offset: 0,
        limit: 10
      });
    }else{
      arr.push({
        page: i,
        offset: ((i-1)*10),
        limit: 10
      });
    }
  }
  return pagedata = {list: arr};
};

function getuser(){
  var user = JSON.parse(localStorage.getItem('user'));
  if(!user){
    var href = window.location.href;
    if(href.indexOf('login.html') == -1){
      window.location.href = 'login.html?ref=' + href;
    };
  }else{
    user = user.user
  };
  return user;
};

function getUrlParam(name){
  // 获取参数
 var url = window.location.search;
   // 正则筛选地址栏
 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
   // 匹配目标参数
 var result = url.substr(1).match(reg);
  //返回参数值
return result ? decodeURIComponent(result[2]) : null;
}

function role(){
  var user = localStorage.getItem('user');
  var role = JSON.parse(user).user.roleId;
  if(role == 1){
    return role;
  }else if(role == 5){
    return role;
  }else{
    $('#add').remove();
    return role;
  }
};


