package com.hibernate.json.controllers;

import com.hibernate.CardType;
import com.hibernate.entity.Card;
import com.hibernate.entity.User;
import com.hibernate.security.auth.JwtDecodeToken;
import com.hibernate.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/newCard", method = RequestMethod.GET)
    public ResponseEntity<Card> newCard(@RequestHeader(value = "Authentication") String token, @RequestParam(value = "card_type") CardType cardType) {
        User a = JwtDecodeToken.decodeUserJwt(token);
        return new ResponseEntity<Card>(cardService.newCard(cardType, a.getId()), HttpStatus.OK);
    }
}
