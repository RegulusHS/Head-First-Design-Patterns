package chapter6.undo;

public class NoCommand implements Command {
	@Override
	public void execute() { }
	@Override
	public void undo() { }
}
