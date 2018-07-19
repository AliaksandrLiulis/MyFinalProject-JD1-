package by.myProject.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.myProject.controller.command.commandInterfaces.ICommand;
import by.myProject.controller.command.impl.Sign_inUser;
import by.myProject.controller.command.impl.AddNewWorker;
import by.myProject.controller.command.impl.Add_User;
import by.myProject.controller.command.impl.Authorize_User;
import by.myProject.controller.command.impl.ChangeData;
import by.myProject.controller.command.impl.DoRemoveWorker;
import by.myProject.controller.command.impl.Do_Avaliable_User;
import by.myProject.controller.command.impl.Do_remove_User;
import by.myProject.controller.command.impl.Exit;
import by.myProject.controller.command.impl.RegisterUser;
import by.myProject.controller.command.impl.RemoveWorker;
import by.myProject.controller.command.impl.Remove_User;
import by.myProject.controller.command.impl.ShowAllBase;
import by.myProject.controller.command.impl.Show_All_Users;

public class CommandsProvider {	
	
	private Map<AllCommands, ICommand> commands;

	public CommandsProvider() {
		commands = new HashMap<AllCommands, ICommand>();
		initialCommandMap();
	}
	
	private void initialCommandMap() {
		
		commands.put(AllCommands.REGISTR, new RegisterUser());
		commands.put(AllCommands.SIGN_IN, new Sign_inUser());
		commands.put(AllCommands.SHOW_ALL_USERS, new Show_All_Users());
		commands.put(AllCommands.ADD_USER, new Add_User());
		commands.put(AllCommands.REMOVE_USER, new Remove_User());
		commands.put(AllCommands.AUTHORIZE_USER, new Authorize_User());
		commands.put(AllCommands.DO_AVALIABLE_USER, new Do_Avaliable_User());
		commands.put(AllCommands.DO_REMOVE_USER, new Do_remove_User());
		commands.put(AllCommands.EXIT, new Exit());
		commands.put(AllCommands.ADD_NEW_WORKER, new AddNewWorker());
		commands.put(AllCommands.SHOW_ALL_BASE, new ShowAllBase());
		commands.put(AllCommands.REMOVE_WORKER, new RemoveWorker());
		commands.put(AllCommands.CHANGE_DATA, new ChangeData());
		commands.put(AllCommands.DO_REMOVE_WORKER, new DoRemoveWorker());
	}
	
	public ICommand getCommand(String commandRequest) {
		ICommand command = null;
		command = commands.get(AllCommands.valueOf(commandRequest.toUpperCase()));
		return command;
	}
}
