from twilio.rest import TwilioRestClient

account_sid = "ACfd98487184b3f48a4bd0a7737b92fff8" # Your Account SID from www.twilio.com/console
auth_token  = "c580bdb5933b76e7247e2ed05d1c9dfb"  # Your Auth Token from www.twilio.com/console

client = TwilioRestClient(account_sid, auth_token)

message = client.messages.create(body="Hello from Python",
    to="+15862651455",    # Replace with your phone number
    from_="+16023130353") # Replace with your Twilio number

print(message.sid)
