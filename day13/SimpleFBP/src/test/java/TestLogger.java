public class TestLogger {
    public static void main(String[] args) {
        Logger logger = new Logger("Test");
        logger.debug("개발자만 볼 것");
        logger.info("그냥 알려주는것");
        logger.warning("좀 덜한 것");
        logger.error("Error!");
    }
}
