import discord
from discord.ext import commands
from twitchAPI.twitch import Twitch

# CONFIGURATION
<<<<<<< HEAD
DISCORD_TOKEN = ""
=======
DISCORD_TOKEN = ""
>>>>>>> ca69040 (10/2/2025)
TWITCH_CLIENT_ID = "your_twitch_client_id"
TWITCH_CLIENT_SECRET = "your_twitch_client_secret"
TWITCH_CHANNEL = "your_twitch_channel_name"
ROLE_NAME = "SUB"  # Role to assign on Discord

# Initialize Twitch API
twitch = Twitch(TWITCH_CLIENT_ID, TWITCH_CLIENT_SECRET)
twitch.authenticate_app()

# Initialize Discord bot
intents = discord.Intents.default()
intents.members = True  # Required to manage members
bot = commands.Bot(command_prefix="!", intents=intents)

# Check if a user is subscribed on Twitch
def is_twitch_subscriber(username):
    try:
        channel_info = twitch.get_users(logins=[TWITCH_CHANNEL])
        broadcaster_id = channel_info['data'][0]['id']

        subscribers = twitch.get_broadcaster_subscriptions(broadcaster_id)
        for sub in subscribers['data']:
            if sub['user_name'].lower() == username.lower():
                return True
        return False
    except Exception as e:
        print(f"Error checking Twitch subscription: {e}")
        return False

# Command to link Discord and Twitch usernames
@bot.command()
async def link(ctx, twitch_username: str):
    guild = ctx.guild
    member = ctx.author

    # Check if the user is subscribed on Twitch
    if is_twitch_subscriber(twitch_username):
        # Get the role
        role = discord.utils.get(guild.roles, name=ROLE_NAME)

        if role:
            # Assign the role
            await member.add_roles(role)
            await ctx.send(f"🎉 {member.mention}, you've been given the {ROLE_NAME} role for being a Twitch subscriber!")
        else:
            await ctx.send("🚫 Role not found. Please contact the server admin.")
    else:
        await ctx.send(f"🚫 {twitch_username} is not subscribed to {TWITCH_CHANNEL}.")

# Run the bot
bot.run(DISCORD_TOKEN)