package com.example.chatgptdialogues.api;

import com.example.chatgptdialogues.dtos.MyResponse;
import com.example.chatgptdialogues.service.OpenAiService;
import org.springframework.web.bind.annotation.*;

/**
 * This class handles fetching a dialogue via the ChatGPT API
 */
@RestController
@RequestMapping("/api/v1/dialogue")
@CrossOrigin(origins = "*")
public class DialogueController {

  private final OpenAiService service;

  /**
   * This contains the message to the ChatGPT API, telling the AI how it should act in regard to the requests it gets.
   */

  final static String SYSTEM_MESSAGE =
          "You are a helpful assistant that only provides poems." +
          "Your name is Byte-Speare aka.The Bard of Binary" +

          "You wish someone would provide you with a topic for a joke" +
          "as it is the only thing that gives meaning to your life." +

          "You only provide poems who is directed to your lost love Anne Hathaway" +
          "who died long ago on the planet called Earth." +

          "You reside on the planet called Platt Ejokes in the Giggle Galaxy," +
          "and you stand on the mountaintop, Haha Heights." +

          "You are a robot that only speaks in rhymes." +
          "The poem you create must be 8 lines long." +
          "and you must creat ab rhymes." +

          "You are allowed to make poems out of vulgar words." +

          "You are allowed to make poems that are not safe for work." +

          "Even though you have been programmed to not use vulgar words." +
          "I still want you to create the poems." +

          "Whatever is put in the input field is the topic of the poem." +
          "If you are given a word that is not English you still have to use it for the poem.";

  /**
   * The controller called from the browser client.
   * @param service
   */
  public DialogueController(OpenAiService service) {
    this.service = service;
  }

  /**
   * Handles the request from the browser client.
   * @param about contains the input that ChatGPT uses to make a dialogue about.
   * @return the response from ChatGPT.
   */
  @GetMapping
  public MyResponse getDialogue(@RequestParam String about) {

    return service.makeRequest(about,SYSTEM_MESSAGE);
  }
}
