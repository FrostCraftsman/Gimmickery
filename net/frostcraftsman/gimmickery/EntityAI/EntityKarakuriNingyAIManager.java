package net.frostcraftsman.gimmickery.EntityAI;

import java.util.ArrayList;
import java.util.List;



import net.frostcraftsman.gimmickery.entity.EntityWoodKarakuriNingyG;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityKarakuriNingyAIManager extends EntityAIBase {
    // EntityRobot����AI�ꥹ��
    List<EntityKarakuriNingyAIChild> children = new ArrayList<>();

    // �F�ڻ��Ի����Ƥ�����AI
    EntityKarakuriNingyAIChild working = null;

    // �Τ⤷�ʤ�AI��NullObject�Ĵ���
    EntityKarakuriNingyDoNothing aiDoNothing;

    public EntityKarakuriNingyAIManager(EntityWoodKarakuriNingyG entityWoodKarakuriNingy, float v) {
        // ����AI����AI�ꥹ�Ȥ˵��h
        children.add(new EntityKarakuriNingyAITask1(entityWoodKarakuriNingy));


        // ��������ڻ�������AI�ꥹ��ĩβ�˵��h
        aiDoNothing = new EntityKarakuriNingyDoNothing(entityWoodKarakuriNingy);
        children.add(aiDoNothing);

        // �F���Є�����AI����ڻ�
        working = aiDoNothing;
    }

    @Override
    public boolean shouldExecute() {
        // �Є�����AI������椨��

        // �F���Є�����AI�������A���g�п��ܤʤ餽�Τޤ�ʹ��
        if (working.shouldExecute()) {
            return true;
        }

        // �F���Є�����AI���g�в��ɤʤΤ���AI�ꥹ�Ȥ���ʹ������AI��̽��
        for(EntityKarakuriNingyAIChild child : children) {
            if(child.shouldExecute()) {
                // �Є�����AI������椨
                working = child;
                return true;
            }
        }

        // �Є�����AI��Ҋ�Ĥ���ʤ��ä��ΤǺΤ⤷�ʤ�AI���x�k
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

        // ��AI�Όg�Ф����ˤ����Τǳ���״�B�ˑ���
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

