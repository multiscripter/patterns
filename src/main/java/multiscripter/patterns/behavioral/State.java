package multiscripter.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * Состояние (англ. State) - поведенческий шаблон проектирования.
 * Решает задачу изменения поведения объекта в зависимости от состояния.
 */

enum TLights {
  RED, YELLOW, GREEN
}

interface IState {
  String getLight();
}

/**
 * Красный свет (Concrete state).
 */
class LightRed implements IState {

  @Override
  public String getLight() {
    return TLights.RED.name();
  }
}

/**
 * Жёлтый свет (Concrete state).
 */
class LightYellow implements IState {

  @Override
  public String getLight() {
    return TLights.YELLOW.name();
  }
}

/**
 * Зелёный свет (Concrete state).
 */
class LightGreen implements IState {

  @Override
  public String getLight() {
    return TLights.GREEN.name();
  }
}

/**
 * Светофор (Context).
 */
class TrafficLight {

  private IState state;

  private List<IState> states = new ArrayList<>();

  private int stateNum;

  private String direction = "down";

  public TrafficLight(IState initialState) {
    this.states.add(new LightRed());
    this.states.add(new LightYellow());
    this.states.add(new LightGreen());
    this.state = initialState;
    this.stateNum = TLights.valueOf(this.state.getLight()).ordinal();
  }

  public void turnLight() {
    if (this.direction.equals("down")) {
      if (this.state.getLight().equals(TLights.GREEN.name())) {
        this.direction = "up";
        this.stateNum--;
      } else {
        this.stateNum++;
      }
    } else if (this.direction.equals("up")) {
      if (this.state.getLight().equals(TLights.RED.name())) {
        this.direction = "down";
        this.stateNum++;
      } else {
        this.stateNum--;
      }
    }
    this.state = this.states.get(this.stateNum);
  }

  public String getLight() {
    return this.state.getLight();
  }
}
