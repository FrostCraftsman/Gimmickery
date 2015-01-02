package net.frostcraftsman.gimmickery.EntityAI;

import java.util.ArrayList;
import java.util.List;



import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityKarakuriNingyAIManager extends EntityAIBase {
    // EntityRobot専用AIリスト
    List<EntityKarakuriNingyAIChild> children = new ArrayList<>();

    // 現在活性化している子AI
    EntityKarakuriNingyAIChild working = null;

    // 何もしないAI。NullObject的存在
    EntityKarakuriNingyDoNothing aiDoNothing;

    public EntityKarakuriNingyAIManager(EntityWoodKarakuriNingyG entityWoodKarakuriNingy, float v) {
        // 専用AIを子AIリストに登録
        children.add(new EntityKarakuriNingyAITask1(entityWoodKarakuriNingy));


        // 番兵を初期化して子AIリスト末尾に登録
        aiDoNothing = new EntityKarakuriNingyDoNothing(entityWoodKarakuriNingy);
        children.add(aiDoNothing);

        // 現在有効な子AIを初期化
        working = aiDoNothing;
    }

    @Override
    public boolean shouldExecute() {
        // 有効な子AIを入れ替える

        // 現在有効な子AIが引き続き実行可能ならそのまま使用
        if (working.shouldExecute()) {
            return true;
        }

        // 現在有効な子AIが実行不可なので子AIリストから使える子AIを探す
        for(EntityKarakuriNingyAIChild child : children) {
            if(child.shouldExecute()) {
                // 有効な子AIを入れ替え
                working = child;
                return true;
            }
        }

        // 有効な子AIが見つからなかったので何もしないAIを選択
        working = aiDoNothing;
        return false;
    }

    @Override
    public boolean continueExecuting() {
        return working.continueExecuting();
    }

    @Override
    public boolean isInterruptible() {
        return working.isInterruptible();
    }

    @Override
    public void startExecuting() {
        working.startExecuting();
    }

    @Override
    public void resetTask() {
        working.resetTask();

        // 子AIの実行が完了したので初期状態に戻す
        working = aiDoNothing;
    }

    @Override
    public void updateTask() {
        working.updateTask();
    }

    @Override
    public void setMutexBits(int p_75248_1_) {
        working.setMutexBits(p_75248_1_);
    }

    @Override
    public int getMutexBits() {
        return working.getMutexBits();
    }
}

