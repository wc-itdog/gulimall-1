package gulimall.order.feign.fallback;

import gulimall.common.exception.BizCodeEnume;
import gulimall.common.utils.R;
import gulimall.order.feign.WareFeignService;
import gulimall.order.vo.WareSkuLockVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 远程调用失败的降级处理方法
 *
 * @author 孙启新
 * <br>FileName: WareFeignServiceFallbackHandleImpl
 * <br>Date: 2020/08/20 16:35:25
 */
@Component
@Slf4j
public class WareFeignServiceFallbackHandleImpl implements WareFeignService {
    /**
     * 根据skuIds集合批量查询是否有库存
     *
     * @param skuIds id集合
     * @return R对象
     */
    @Override
    public R getSkuHasStock(List<Long> skuIds) {
        log.error("--------------------------调用远程服务方法 getSkuHasStock 失败,返回降级信息-------------------------");
        return R.error(BizCodeEnume.SENTINEL_DEGRADE_EXCEPTION.getCode(), BizCodeEnume.SENTINEL_DEGRADE_EXCEPTION.getMsg());
    }

    /**
     * 根据传来的数据锁定某件商品的库存
     *
     * @param wareSkuLockVo wareSkuLockVo
     * @return R
     */
    @Override
    public R orderLockStock(WareSkuLockVo wareSkuLockVo) {
        log.error("--------------------------调用远程服务方法 orderLockStock 失败,返回降级信息-------------------------");
        return R.error(BizCodeEnume.SENTINEL_DEGRADE_EXCEPTION.getCode(), BizCodeEnume.SENTINEL_DEGRADE_EXCEPTION.getMsg());
    }
}
