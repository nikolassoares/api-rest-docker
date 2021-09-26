package com.enquete.apirest.resources;

import com.enquete.apirest.models.Options;
import com.enquete.apirest.models.Poll;
import com.enquete.apirest.models.Stats;
import com.enquete.apirest.models.Vote;
import com.enquete.apirest.repository.OptionsRepository;
import com.enquete.apirest.repository.PollRepository;
import com.enquete.apirest.repository.StatsRepository;
import com.enquete.apirest.repository.VoteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/poll")
@Api(value="API REST Poll")
@CrossOrigin(origins = "*")
public class PollResource {

    @Autowired
    PollRepository pollRepository;

    @Autowired
    OptionsRepository optionsRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    StatsRepository statsRepository;

    @GetMapping("/all-polls")
    @ApiOperation(value = "Retorna uma lista de enquetes")
    public List<Poll> getListPolls() {
        return pollRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma enquete por ID")
    public ResponseEntity<?> getPoll(@PathVariable(value = "id") long id) {
        Poll poll = pollRepository.findById(id);

        if (poll != null) {
            Stats stats = statsRepository.findStatsByPoll(poll);
            stats.setViews(stats.getViews() + 1);
            statsRepository.save(stats);
        }

        return !(poll == null) ? ResponseEntity.ok(poll) : ResponseEntity.notFound().build();
    }

    @PostMapping()
    @ApiOperation(value = "Grava uma enquete com suas opções")
    public ResponseEntity<Poll> postPoll(@RequestBody Poll poll) {
        Poll pollSaved = pollRepository.save(poll);
        for (Options options : poll.getOptions()) {
            optionsRepository.save(options);
        }

        Stats statsNew = new Stats();
        statsNew.setPoll(poll);
        statsNew.setViews(0);
        statsRepository.save(statsNew);

        return ResponseEntity.status(HttpStatus.CREATED).body(pollSaved);
    }

    @PostMapping("/{id}/vote")
    @ApiOperation(value = "Grava um voto passando o ID da opção")
    public ResponseEntity<String> postVote(@PathVariable(value = "id") long id) {
        Options option = optionsRepository.findById(id);

        if (option != null) {
            Vote vote = voteRepository.filterFromOption(option.getOption_id());
            if (vote == null) {
                Vote voteNew = new Vote();
                voteNew.setOption_id(option.getOption_id());
                voteNew.setQty(1);
                voteRepository.save(voteNew);
            } else {
                vote.setQty(vote.getQty() + 1);
                voteRepository.save(vote);
            }
        }

        return !(option == null) ? ResponseEntity.ok("Vote registred") : ResponseEntity.notFound().build();
    }


    @GetMapping("/{id}/stats")
    @ApiOperation(value = "Retorna estatísticas de uma enquete, passando o ID da enquete")
    public ResponseEntity<?> getStats(@PathVariable(value = "id") long id) {

        Poll poll = pollRepository.findById(id);
        Stats stats = new Stats();
        if (poll != null) {
            stats = statsRepository.findStatsByPoll(poll);
        }

        return !(poll == null) ? ResponseEntity.ok(stats) : ResponseEntity.notFound().build();
    }

}

