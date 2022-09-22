import java.util.Date;
import java.util.logging.*;

public class Logger {
    private String name;
//    private java.util.logging.Logger logger;
//    private static Handler handler = null;
//
//    static Handler getHandler(){
//        if(Logger.handler == null){
//            handler = new ConsoleHandler();
//            handler.setFormatter(new SimpleFormatter() {
//                private  static final String format = "[%1$tF %1$tT] [%2$-4s] [%3$-16s] %4$s %n";
//
//                @Override
//                public synchronized  String format(LogRecord lr){
//                    return String.format(format,
//                            new Date(lr.getMillis()),
//                            lr.getLevel().getLocalizedName(),
//                            lr.getLoggerName(),
//                            lr.getMessage()
//                    );
//                }
//            });
//        }
//        return Logger.handler;
//    }
    public Logger(String name){
//        this.logger = java.util.logging.Logger.getLogger(name);
//        this.logger.setUseParentHandlers(false);
//        if(this.logger.getHandlers().length == 0){
//            this.logger.addHandler(Logger.getHandler());
//        }
        this.name = name;
    }

    public void debug(String message){
        //this.logger.log(Level.FINE, name);
        System.out.println("[  dedug   ] [ " + this.name + " ] " + message);
    }
    public void info(String message){
//        this.logger.log(Level.INFO, name);
        System.out.println("[   info   ] [ " + this.name + " ] " + message);
    }
    public void warning(String message){
//        this.logger.log(Level.WARNING, name);
        System.out.println("[ warning  ] [ " + this.name + " ] " + message);
    }
    public void sereve(String message){
//        this.logger.log(Level.SEVERE, name);
        System.out.println("[ serveve ] [ " + this.name + " ] " + message);
    }

    public void error(String message) {
        System.out.println("[  error   ] [ " + this.name + " ] " + message);
    }
}
