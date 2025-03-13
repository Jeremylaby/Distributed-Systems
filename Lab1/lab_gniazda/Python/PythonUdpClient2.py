import socket

serverIP = "127.0.0.1"
serverPort = 9008
msg_bytes = (300).to_bytes(4, byteorder='little')  # Little-endian

print('PYTHON UDP CLIENT')
client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

client.sendto(msg_bytes, (serverIP, serverPort))
print(f"Sent number: 300")

response, _ = client.recvfrom(4)
received_number = int.from_bytes(response, byteorder='little')

print(f"Received number: {received_number}")
client.close()
