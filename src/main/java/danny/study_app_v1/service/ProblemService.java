package danny.study_app_v1.service;

import danny.study_app_v1.entity.ListEntity;
import danny.study_app_v1.entity.Problem;
import danny.study_app_v1.repository.ListRepository;
import danny.study_app_v1.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private ListRepository listRepository;

    public List<Problem> getProblemsByListId(Long listId) {
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "List not found"));
        return list.getProblems();
    }

    public Problem getProblemById(Long id) {
        return problemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Problem not found"));
    }

    public Problem createProblem(Long listId, Problem problem) {
        ListEntity list = listRepository.findById(listId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "List not found"));
        problem.setList(list);
        return problemRepository.save(problem);
    }

    public Problem updateProblem(Long id, Problem problemDetails) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Problem not found"));

        problem.setName(problemDetails.getName());
        problem.setNotes(problemDetails.getNotes());
        problem.setTag1(problemDetails.getTag1());
        problem.setTag2(problemDetails.getTag2());
        problem.setTag3(problemDetails.getTag3());
        problem.setImportance(problemDetails.getImportance());
        problem.setConfidence(problemDetails.getConfidence());

        return problemRepository.save(problem);
    }

    public void updateLastAttempted(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Problem not found"));
        problem.setLastAttempted(LocalDateTime.now());
        problemRepository.save(problem);
    }

    public void deleteProblem(Long id) {
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Problem not found"));
        problemRepository.delete(problem);
    }
}

