import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

public final class main {


    public static void main(final String[] args) {

            final String token = "OTUzNjMxMTc4OTI4MzEyMzYx.YjHYPg.34frQWgo3hPxDt2Wmx5Xt5SeLSI"; //Aqui esta el token del bot creado por mi
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        gateway.on(MessageCreateEvent.class).subscribe(event -> { // en el codigo lo que hacemos es pedir al vot un ping y nos devuelve pong
            final Message message = event.getMessage();
            if ("!ping".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("Pong!").block(); //aqui se indica lo de pong de tal manera que devolvera !pong
            }
        });

        gateway.onDisconnect().block();

    }

    }





