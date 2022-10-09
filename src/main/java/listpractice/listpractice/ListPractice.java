package listpractice.listpractice;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class ListPractice extends JavaPlugin {

    List<String> list = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (command.getName().equalsIgnoreCase("mlist")) {

            if (args.length == 0) {

                sender.sendMessage("/mlist with [文字] : [文字]をListに挿入します。");
                sender.sendMessage("/mlist dipo : Listを出力します。");
                sender.sendMessage("/mlist remove [数字] : Listの[数字]番目を削除します。");
                sender.sendMessage("/mlist clear : Listを初期化します。");
                return true;

            }

            if(args[0].equals("with")) {

                if (args.length != 2) {

                    sender.sendMessage("使い方が間違っています！");
                    return false;

                }

                list.add(args[1]);
                sender.sendMessage(args[1] + "をListに追加しました。");
                return true;

            }

            if (args[0].equals("dipo")) {

                for (int i = 0; i < list.size(); i++) sender.sendMessage("[" + i + "] " + list.get(i));
                return true;

            }

            if (args[0].equals("clear")) {

                list.clear();
                sender.sendMessage("Listを初期化しました。");
                return true;

            }

            if (args[0].equals("remove")) {

                int n;

                try {

                    n = Integer.parseInt(args[1]);

                } catch (NumberFormatException e) {

                    sender.sendMessage("数字で入力宇してください");
                    return false;

                }

                if (list.size() <= n) {

                    sender.sendMessage("数字が大きすぎます。");
                    return false;

                }

                list.remove(n);
                sender.sendMessage(n + "番目のListを削除しました。");
                return true;

            }

        } else {

            sender.sendMessage("使い方が間違っています");
            return false;

        }

        return true;

    }

}
