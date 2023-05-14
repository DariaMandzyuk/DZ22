object ChatService {
    private var messages = mutableListOf<Message>()
    private var chats = mutableListOf<Chat>()
    private var lastId = 0

    fun getChats(userId: Int): MutableList<Chat> {
        return chats.filter { !it.isDeleted && it.userId == userId }.toMutableList()
    }

    fun getUnreadChatsCount(userId: Int): Int {
    return chats.filter { !it.isDeleted && it.userId == userId && !it.isRead}.toMutableList().size
    }

    fun getNotDeletedMessagesFromOneChat(userId: Int): String {
        val listOfNotDeletedMessages = mutableListOf<Message>()
        for (chat in chats) {
            if (!chat.isDeleted && chat.userId == userId) {
                for (message in chat.messages) {
                    if (!message.isDeleted) {
                        listOfNotDeletedMessages.add(message)
                    }
                }
            }
        }
        return if (listOfNotDeletedMessages.isEmpty()) {
            "Нет сообщений"
        } else {
            listOfNotDeletedMessages.toString()
        }
    }

    fun getListOfMessagesFromIdAndChatIdAndNumbers(messageId: Int, chatId: Int, numberOfMessages: Int): MutableList<Message> {
        val listOfMessagesFromIdAndChatIdAndNumbers = mutableListOf<Message>()
        var count = 0
        for (chat in chats) {
            if (!chat.isDeleted && chat.id == chatId) {
                for (message in chat.messages) {
                    if (message.id < messageId && count <= numberOfMessages) {
                        listOfMessagesFromIdAndChatIdAndNumbers.add(message)
                        message.isRead = true
                        count++
                    }
                }
            }
        }
        return listOfMessagesFromIdAndChatIdAndNumbers
    }


        fun deleteChat(id: Int, userId: Int): Boolean {
            for (chat in chats) {
                if (chat.id == id && chat.userId == userId) {
                    chat.isDeleted = true
                    chat.messages = mutableListOf()
                    return true
                }
            }
            throw ChatNotFoundException("Chat with id $id not found")
        }

        fun createChat(userId: Int, message: Message): Chat {
            for (chat in chats) {
                if (chat.userId == userId) {
                    return chat
                }
            }
            var chatNew = Chat(id = ++lastId, userId = userId, messages = messages + message)
            chats += chatNew
            return chats.last()
        }

        fun createMessage(chatId: Int, messageVneshnii: Message, userId: Int): Int {
            for (chat in chats) {
                if (chat.id == chatId && !chat.isDeleted && chat.userId == userId) {
                    chat.messages += messageVneshnii
                    return chat.messages.last().id
                }
            }
            throw ChatNotFoundException("Chat with id $chatId not found or deleted")
        }

        fun editMessage(chatId: Int, messageId: Int, messageText: String, userId: Int): Boolean {
            for (chat in chats) {
                if (chat.id == chatId && !chat.isDeleted && chat.userId == userId) {
                    for (message in chat.messages) {
                        if (message.id == messageId && !message.isDeleted) {
                            message.text = messageText
                            return true
                        }
                    }
                    throw MessageNotFoundException("Message with id $messageId not found or deleted")
                }
            }
            throw ChatNotFoundException("Chat with id $chatId not found or deleted")
        }

        fun deleteMessage(chatId: Int, messageId: Int, userId: Int): Boolean {
            for (chat in chats) {
                if (chat.id == chatId && !chat.isDeleted && chat.userId == userId) {
                    for (message in chat.messages) {
                        if (message.id == messageId && !message.isDeleted) {
                            message.isDeleted = true
                            return true
                        }
                    }
                    throw MessageNotFoundException("Message with id $messageId not found or deleted")
                }
            }
            throw ChatNotFoundException("Chat with id $chatId not found or deleted")
        }

    }