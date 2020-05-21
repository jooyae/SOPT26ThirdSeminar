
## SOPT third project

***1. Postman을 이용한 로그인, 회원가입 구현 
***2. Request / Response 객체
***3. Retrofit Interface 구현체 생성 
***4. Callback 등록과 통신 요청 

 ***
 ## MEMO
 
 

 1. JSON data 사용시, 서버에서 정한 변수가 아닌 내가 이름을 지어주고 싶을 때 
 

         data class ResponseLogin(  
            val status : Int,  
            val success : Boolean,  
          **@SerializedName("data")**  
            val data: SomeData?  
        )
2. requestLogin/Register에서 로그인 정보 전달 후 Callback 등록해주고 Retrofit의 Callback import 해주기 
3. Retrofit Interface 설계

	    interface RequestInterface{  
        @POST("user/signin/")  
        fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>  
        @POST("user/signup/")  
        fun requestRegister(@Body body: RequestRegister) : Call<ResponseRegister>  
    }
***
## Screenshot
![xxx](https://user-images.githubusercontent.com/58849278/82594761-8d5e4800-9bdf-11ea-8423-96a942eb5fda.gif)
