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
![role1](https://user-images.githubusercontent.com/67946662/107740365-4a846780-6d4e-11eb-94bb-281fe12fe636.JPG) ![role2](https://user-images.githubusercontent.com/67946662/107740369-4f491b80-6d4e-11eb-92fb-741339943e89.JPG) ![role4](https://user-images.githubusercontent.com/67946662/107740373-53753900-6d4e-11eb-84cc-e0aceff9cbc0.JPG)  

* 역할과 미션을 보여주는 페이지입니다.  
* 인원수에 따라 스파이의 수를 조정했으며, 역할의 수를 동적으로 조정하기 위해 arraylist를 사용했습니다.  

```
        if(totalnum<=5)
            spynum = 1;
        else
            spynum = 2;

        citizennum = totalnum-spynum-1; // 시민수 = 전체수-스파이수-사회자1인

        ArrayList<String> roles = new ArrayList<String>();
        roles.add("사회자");
        for(int i=0;i<spynum;i++)
            roles.add("SPY");
        for(int i=0;i<citizennum;i++)
            roles.add("시민");
```  

* 모든 역할과 미션은 Collections의 shuffle 기능을 이용하여 매번 역할과 미션이 랜덤으로 달라질 수 있도록 했습니다.  

```
        //역할 셔플
        Collections.shuffle(roles);
        
        // 미션 셔플(매번 랜덤으로 각 시민마다 미션이 다르게 나오기 위함)
        Collections.shuffle(Arrays.asList(citizenmission));
```  

* 게임에 참여하는 인원은 한사람씩 핸드폰을 돌려가며 자신의 역할과 미션을 확인합니다.  
* 역할과 미션을 확인하고 바로 버튼을 누르면 다음 사람의 역할을 볼 수 있기 때문에  
그를 방지하기 위해 역할 확인 시간을 8초로 정하고 8초가 지나면 역할과 미션이 비가시화되도록 설정하였습니다.  
```
                    Handler mHandler = new Handler();
                    mHandler.postDelayed(new Runnable() {
                        public void run() {

                            // 다음 사람에게 이전 사람의 역할과 미션이 보이지 않도록
                            // 미션을 확인할 8초가 지나면 확인하는 사람의 미션과 역할 text가 안보이게 됨
                            roletext.setVisibility(View.INVISIBLE);
                            missiontext.setVisibility(View.INVISIBLE);
                        }
                    }, 8000); // 8초후
```  

  
------------
