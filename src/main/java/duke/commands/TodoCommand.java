package duke.commands;

import duke.Ui;
import duke.tasks.TaskList;
import duke.tasks.Todo;

/**
 * Encapsulates the information of a TodoCommand object that contains a Todo.
 */
public class TodoCommand extends Command {

    private final Todo task;

    public TodoCommand(Todo task) {
        this.task = task;
    }

    @Override
    public void executeCommand(TaskList taskList) {
        taskList.addTask(task);
        Ui.taskAddedMessage(task, taskList.getTaskCount());
    }
}
