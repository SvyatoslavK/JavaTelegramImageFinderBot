package github.telegramimagefinderbot.jpbft.command;

public enum CommandName {

    START("/start"),
    STOP("/stop"),
    GREETINGS("/greetings"),
    MESSAGE("/message"),
    PICTURE("/getpicture"),
    HELP("/help"),
    STATS("/stats"),

    LISTSITESSUB("/listSitesSub"),
    ADDSITESUB("/addSiteSub "),
    REMOVESITESSUB("/removeSitesSub"),

    POST("/post") /*for posting images to the channel */,
    DISLIKE("/dislike")/*for rejecting posting to the channel */;

    private final String commandName;

    CommandName(String commandName)
    {
        this.commandName = commandName;
    }

    public String getCommandName()
    {
        return commandName;
    }
}
