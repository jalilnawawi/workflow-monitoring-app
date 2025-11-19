package jalilspringproject.workflow_monitoring_app.service.impl;

import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.request.CaseStageRequestDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.CaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.model.dto.case_stage.response.GetCaseStageResponseDto;
import jalilspringproject.workflow_monitoring_app.repository.CaseStageRepository;
import jalilspringproject.workflow_monitoring_app.service.CaseStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseStageServiceImpl implements CaseStageService {
    @Autowired
    CaseStageRepository caseStageRepository;

    @Override
    public CaseStageResponseDto createCaseStage(CaseStageRequestDto caseStageRequestDto) {
        return null;
    }

    @Override
    public GetCaseStageResponseDto getAll() {
        return null;
    }

    @Override
    public GetCaseStageResponseDto getById(Long id) {
        return null;
    }

    @Override
    public CaseStageResponseDto updateCaseStage(Long id, CaseStageRequestDto caseStageRequestDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
