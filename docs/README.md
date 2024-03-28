# 아아아앗 커밋을 한번에 해버렸다 ㅠㅠ

## Application.java

#### static void main(String[] args)
- Game 객체를 생성하고 게임을 시작합니다.
- try, catch 안에 게임 시작 코드를 넣었는데, 이는 예상치 못한 오류가 발생했을 때 IllegalArgumentException를 호출하기 위한 것 입니다.

## Game.java

#### Game()
- 게임 객체가 처음 생성될 때 BufferWriter을 생성하기 위해 적었습니다.

#### int toInt(String string)
- 문자열을 정수로 변환하기 위해 만들었습니다.
- 문자열이 정수로 변환할 수 없으면 -1을 반환합니다.

#### void InputCars()
- 자동차 입력을 위한 함수입니다.
- (,)로 나눈 각 문자열로 CarData 객체를 생성하였습니다.
- 자동차 이름이 5자를 초과하면 에러를 발생시킵니다.

#### void InputCount()
- 경주를 반복할 횟수를 입력하기 위한 함수입니다.
- toInt() 함수를 이용해 문자열을 정수로 바꾸고, 해당 정수가 1보다 작으면 에러를 발생시킵니다.

#### void UpdateCars()
- 데이터에 존재하는 모든 CarData객체를 업데이트 시킵니다.
- 각 CarData는 업데이트마다 랜덤값이 4이상이면 한칸씩 이동합니다.
- 각 CarData를 업데이트 시킨 후, 자동차의 진행상황을 출력합니다.

#### void OutputWinner()
- 모든 자동차 업데이트가 끝난 후, 우승자를 추려내서 출력합니다.

#### void StartGame()
- 게임을 시작하는 함수입니다.
- 여기에서 모든 함수들을 실행하고, 자동차들을 업데이트 합니다.

## CarData.java

#### String name;
- 자동차 이름에 대한 변수입니다.
#### int runcount;
- 자동차의 진행사항에 대한 변수입니다.
#### CarData(String name)
- 자동차를 생성할 때 이름을 저장하기 위해 작성하였습니다.
#### void Update()
- 자동차의 업데이트 함수입니다. 랜덤값이 4이상이면 runcount변수가 1증가합니다.
#### void addCount()
- runcount++; //을 실행합니다.