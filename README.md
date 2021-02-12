## :shipit:SPYWAR:shipit:
------------

:small_blue_diamond: 개발기간  
/ 2021.02.08~2021.02.12  
:small_blue_diamond: 기획배경  
/ 일반인들도 만나서 놀 때 술게임이 아닌 런닝맨같은 게임을 할 수 있지 않을까?하는 생각에서 기획했다.
  이 어플리케이션을 이용하여 편리하게 게임을 진행할 수 있을 것이다. 
  이 게임의 옵션에는 단순히 앉아서 하는 옵션 뿐 아니라 이름표를 직접 제작하여 진행할 수 있는 옵션도 있다.
  동아리, 동창회 등 많은 사람들이 모였을 때 아이스브레이킹하기 좋은 게임이다.

------------

### 기능설명



### [main_page]
![mainpage](https://user-images.githubusercontent.com/67946662/107739136-8ec23880-6d4b-11eb-856b-ad8a3a7361f8.JPG)  
* 애플리케이션을 켜면 바로 보이는 페이지입니다.
* 스파이이미지의 아이콘을 클릭하면 게임을 시작하는 페이지로 이동합니다.
* HOWTO... 위의 권총 아이콘을 클릭하면, 게임을 설명하는 custom dialog가 등장합니다.


### [custom_dialog]
![customdialog](https://user-images.githubusercontent.com/67946662/107739339-fd06fb00-6d4b-11eb-819f-4d6df137cb1b.JPG)
* 게임에 대한 전반적인 설명이 담겨있습니다.
* textview 안의 내용이 길어져, 한번에 담기 위해 scrollview를 textview 안에 설정하였습니다.

```
        TextView description = (TextView) dlg.findViewById(R.id.description);
        // 설명의 내용이 길어져 화면을 넘어가게 되므로 scrollview를 설정해준다.
        description.setMovementMethod(new ScrollingMovementMethod());
```    


### [Select page]
![selectpage](https://user-images.githubusercontent.com/67946662/107739472-49ead180-6d4c-11eb-8fd1-51f073c08155.JPG)

* 스파이아이콘을 클릭하면 보이는 페이지로 두 가지 옵션을 선택할 수 있습니다.
* "대화로 게임하기", "이름표떼기로 게임하기" 두 가지입니다.
* 가장 큰 차이는 앉아서, 서서 게임을 한다는 점입니다.    
  

### [NumberInput page]
![gamenum](https://user-images.githubusercontent.com/67946662/107739588-8a4a4f80-6d4c-11eb-84fb-3c2c5a67110b.JPG)  

* 게임을 하는 총 인원수를 입력할 수 있습니다.
* 게임 인원에 따라 스파이의 수가 달라집니다.



### [Role page]
<p align>
![role1](https://user-images.githubusercontent.com/67946662/107740090-9f73ae00-6d4d-11eb-9416-6af0b641ec9c.JPG)
![role2](https://user-images.githubusercontent.com/67946662/107740099-a26e9e80-6d4d-11eb-8a78-f9b319d17b2f.JPG)
![role4](https://user-images.githubusercontent.com/67946662/107740107-a5698f00-6d4d-11eb-941e-3888488046c2.JPG)
</p>
  
  
  
------------
