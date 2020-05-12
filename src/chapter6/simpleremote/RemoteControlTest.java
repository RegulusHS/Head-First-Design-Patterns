package chapter6.simpleremote;

/**
 * 这是命令模式的客户
 */
public class RemoteControlTest {
    public static void main(String[] args) {
        //遥控器就是调用者,会传入一个命令对象,可以用来发出请求
        SimpleRemoteControl remote = new SimpleRemoteControl();
        //现在创建了一个电灯对象,此对象也就是请求的接收者
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        //在这里创建一个命令,然后将接收者传给它
        LightOnCommand lightOn = new LightOnCommand(light);
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        //把命令传给调用者
        remote.setCommand(lightOn);
        //然后模拟按下按钮
        remote.buttonWasPressed();
        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }
}
