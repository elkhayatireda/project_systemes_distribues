# E-Bank AI Assistant

**By Reda EL KHAYATI**

This service provides an AI chatbot for the E-Bank microservices project. Built with Spring AI, it can answer questions and use tools exposed by Customer-Service and EBank-Service through the Model Context Protocol (MCP).

## Features

- Chat with the AI agent through a REST API
- Look up customer information and manage bank accounts through MCP
- Connect the chatbot to Discord and Telegram
- Use the Discovery Service and Gateway to communicate with the other services

## Architecture

```text
REST / Discord / Telegram
           |
           v
       AI Agent
           | MCP
     +-----+------+
     v            v
Customer-Service  EBank-Service
```

## Starting the services

Start the services in this order:

1. Discovery Service
2. Customer-Service and EBank-Service
3. Gateway
4. E-Bank AI Assistant

Make sure the services and any required AI or bot credentials are configured in their application settings before starting them.

## Screenshots

**Discord**

![E-Bank chatbot in Discord](images/img_9.png)

**Telegram**

![E-Bank chatbot in Telegram](images/img_10.png)
