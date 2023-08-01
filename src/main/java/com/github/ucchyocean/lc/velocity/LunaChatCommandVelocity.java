/*
 * @author     Emorard
 * @license    LGPLv3
 * @copyright  Copyright Emorard 2020
 */
package com.github.ucchyocean.lc.velocity;

import com.github.ucchyocean.lc.command.LunaChatCommand;
import com.github.ucchyocean.lc.member.ChannelMember;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LunaChatCommandVelocity implements SimpleCommand {

    private LunaChatCommand command;

    public LunaChatCommandVelocity() {
        command = new LunaChatCommand();
    }

    /**
     * Executes the command for the specified {@link CommandSource}.
     *
     * @param source the source of this command
     * @param args   the arguments for this command
     */
    @Override
    public void execute(final Invocation invocation) {

        CommandSource source = invocation.source();
        // Get the arguments after the command alias
        String[] args = invocation.arguments();

        command.execute(ChannelMember.getChannelMember(source), "ch", args);
    }

    /**
     * Provides tab complete suggestions for a command for a specified {@link CommandSource}.
     *
     * @param source      the source to run the command for
     * @param currentArgs the current, partial arguments for this command
     * @return tab complete suggestions
     */
    @Override
    public List<String> suggest(final Invocation invocation) {

        CommandSource source = invocation.source();
        // Get the arguments after the command alias
        String[] currentArgs = invocation.arguments();

        return command.onTabComplete(ChannelMember.getChannelMember(source), "ch", currentArgs);
    }
}
