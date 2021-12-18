package com.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author cinema
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class CinemaApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CinemaApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  项目启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
             "_______________   ______________________________.___.________    _______  ___________\n" +
                "\\_   _____/\\   \\ /   /\\_   _____/\\______   \\__  |   |\\_____  \\   \\      \\ \\_   _____/\n" +
                " |    __)_  \\   Y   /  |    __)_  |       _//   |   | /   |   \\  /   |   \\ |    __)_ \n" +
                " |        \\  \\     /   |        \\ |    |   \\\\____   |/    |    \\/    |    \\|        \\\n" +
                "/_______  /   \\___/   /_______  / |____|_  // ______|\\_______  /\\____|__  /_______  /\n" +
                "        \\/                    \\/         \\/ \\/               \\/         \\/        \\/ \n" +
                "__________ ____ _____________  _____________ ______________                          \n" +
                "\\______   \\    |   \\______   \\/   _____/    |   \\_   _____/                          \n" +
                " |     ___/    |   /|       _/\\_____  \\|    |   /|    __)_                           \n" +
                " |    |   |    |  / |    |   \\/        \\    |  / |        \\                          \n" +
                " |____|   |______/  |____|_  /_______  /______/ /_______  /                          \n" +
                "                           \\/        \\/                 \\/                           \n" +
                "_______________________________ ____ ______________                                  \n" +
                "\\__    ___/\\______   \\______   \\    |   \\_   _____/                                  \n" +
                "  |    |    |       _/|       _/    |   /|    __)_                                   \n" +
                "  |    |    |    |   \\|    |   \\    |  / |        \\                                  \n" +
                "  |____|    |____|_  /|____|_  /______/ /_______  /                                  \n" +
                "                   \\/        \\/                 \\/                                   ");
    }
}
