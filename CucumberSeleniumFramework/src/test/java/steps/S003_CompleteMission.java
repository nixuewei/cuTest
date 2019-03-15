package steps;

import com.cucumber.framework.implementation.TodoList;
import cucumber.api.java.zh_cn.*;
import cucumber.api.PendingException;
import static org.junit.Assert.*;

public class S003_CompleteMission {
    TodoList todo;

    @假设("^我的任务清单里有(\\d+)个任务$")
    public void iHaveSomeTasks(int totalTasks) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todo = new TodoList();
        todo.setTotalTaskCount(totalTasks);
    }

    @当("^我完成(\\d+)件任务之后$")
    public void iFinishSomeTasks(int finishedTasks) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        todo.finishTask(finishedTasks);
    }

    @那么("^我还剩下(\\d+)件未完成的任务$")
    public void iLeftSomeTasks(int leftTasks) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(todo.getRestTasksCount(), leftTasks);
    }
}
