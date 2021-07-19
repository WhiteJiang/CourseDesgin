function sign_in() {
  var val_vc = document.getElementById('vc').value.toLowerCase();
  var val_name = document.getElementById('Account').value;
  var val_pwd = document.getElementById('Pwd').value;
  var num = show_num.join('').toLowerCase();
  if (val_vc && val_name && val_pwd) {
    if (val_vc === num){
      var name = document.getElementById('Account').value;
      var pwd = document.getElementById('Pwd').value;
      var remember = document.getElementById('remember');
      if (remember.checked === true) {
        window.localStorage.setItem('Account', name);
        window.localStorage.setItem('Pwd', pwd);
      } else {
        window.localStorage.removeItem('Account');
        window.localStorage.removeItem('Pwd');
      }
      //document.forms[0].submit();
      document.Login_sub.submit();
    } else {
      alert("错误！！！");
      draw(show_num, 'canvas');
    }
  }
}
//register
function bool_email(a) {
  var length = a.length;
  var string = a.substring(length - 7, length);
  var stringEmail = '@qq.com';
  var stringEmail1 = '@QQ.com';
  return string === stringEmail || string === stringEmail1;
}
function sign_up(){
  if (bool_email(document.getElementById("Email").value)){
    //document.forms[1].submit();
    document.Register_sub.submit();
  } else {
    alert('邮箱错误!!!');
  }
}
