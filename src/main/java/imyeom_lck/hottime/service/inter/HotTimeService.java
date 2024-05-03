package imyeom_lck.hottime.service.inter;

public interface HotTimeService {
    String hottimeApply(String loginId);

    boolean checkIfValue(String loginId);
}
