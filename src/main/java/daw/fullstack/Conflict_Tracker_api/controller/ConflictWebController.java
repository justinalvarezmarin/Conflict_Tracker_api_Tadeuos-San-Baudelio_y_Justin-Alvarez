package daw.fullstack.Conflict_Tracker_api.controller;

import daw.fullstack.Conflict_Tracker_api.service.ConflictService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/conflicts")
public class ConflictWebController {

    private final ConflictService conflictService;

    public ConflictWebController(ConflictService conflictService) {
        this.conflictService = conflictService;
    }

    @GetMapping
    public String getAllConflicts(Model model) {
        // Ahora conflictService.findAll() ya existe y no dará error
        model.addAttribute("conflicts", conflictService.findAll());
        return "conflict-list"; // Asegúrate de que este .html existe en templates
    }
}