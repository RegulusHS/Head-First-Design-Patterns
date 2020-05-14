package chapter6.undo;

public interface Command {
	void execute();
	void undo();
}
