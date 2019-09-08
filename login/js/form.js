  // $(function() {
      //   // $(".header").show(2000);
      //   validate_num1();
      //   $(".submit").click(function(e) {
      //     e.preventDefault();
      //     let flag = validate();
      //     if(flag){
      //       validate_num();
      //     }
      //   });
      // });

      // function validate_num1(){
      //   let arr = ["+", "-", "*"];
      //   let num1 = Math.floor(Math.random() * 100 + 1);
      //   let num2 = Math.floor(Math.random() * 100 + 1);
      //   let operator = arr[Math.floor(Math.random() * 3)];
      //   let str = num1 + operator + num2;
      //   $('.validation').text(str);
      // }

      // function validate() {
      //   let flag = true;
      //   $(":text,:password").each((index, element) => {
      //     if ($(element).val() == "") {
      //       let title = $(element)
      //         .prev()
      //         .text();
      //       flag = false;
      //       alert("请输入" + title);
      //       $(element).focus();
      //       return false;
      //     }
      //   });
      //   return flag;
      // }

      // function validate_num() {
      //   $(":text,:password").each((index, element) => {
      //     if ($(element).prev().text() == "用户名:") {
      //         if ($(element).val().length < 4 && $(element).val() != "") {
      //           // alert("用户名至少为4位！");
      //           $('#username').text("用户名至少为4位！");
      //         }
      //     }if ($(element).prev().text() == "密码:") {
      //           if (($(element).val().length > 12 || $(element).val().length < 6) &&$(element).val() != "") {
      //               // alert("密码为6位至12位！");
      //               $('#password1').text("密码为6位至12位！");
      //           }
      //       }
      //       // if($(element).prev().text() == "确认密码:"){
      //       //     if (($(element).val().length > 12 || $(element).val().length < 6) &&$(element).val() != ""){
      //       //         if($('#pwd1').val() != $(element).val()){
      //       //             $('#password2').text("两次密码输入不同！");
      //       //             // alert("两次密码输入不同！");
      //       //         }
      //       //     }
      //       // }
      //       if($(element).prev().text() == "身份证号码:"){
      //           if(true){
      //               $('#idcard').text("身份证格式不正确！");
      //           }
      //       }
      //       if($(element).prev().text() == "邮箱:"){
      //           if(true){
      //               $('#email').text("邮箱格式不正确！");
      //           }
      //       }
      //       if($(element).prev().text() == "手机号码:"){
      //           if(true){
      //               $('#email').text("手机号码不正确！");
      //           }
      //       }
      //       if($(element).prev().text() == "验证码:"){
      //           if(true){
      //               $('#email').text("验证码错误！");
      //               validate_num1();  
      //           }
      //       }
      //   });
      // }