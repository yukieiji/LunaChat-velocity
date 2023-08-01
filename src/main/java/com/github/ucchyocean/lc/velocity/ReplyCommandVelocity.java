/*
 * @author     Emorard
 * @license    LGPLv3
 * @copyright  Copyright Emorard 2020
 */
package com.github.ucchyocean.lc.velocity;

import com.github.ucchyocean.lc.command.LunaChatReplyCommand;
import com.github.ucchyocean.lc.member.ChannelMember;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;

public class ReplyCommandVelocity implements SimpleCommand {

    private LunaChatReplyCommand command;

    public ReplyCommandVelocity() {
        command = new LunaChatReplyCommand();
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

        command.execute(ChannelMember.getChannelMember(source), "r", args);
    }
}
