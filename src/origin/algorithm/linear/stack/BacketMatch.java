package origin.algorithm.linear.stack;

/**
 * @author 原初
 * @create 2022 - 03 - 18
 * 栈解决括号匹配问题
 */
public class BacketMatch {
    Stack<Character> charStack;
    String content;
    boolean isHard;

    public BacketMatch(String content, boolean isHard) {
        this(new LinkedStack<Character>(), content, isHard);
    }

    public BacketMatch(Stack<Character> stack, String content, boolean isHard) //是否开启严格模式
    {
        this.content = content;
        charStack = stack;
        this.isHard = isHard;
    }
    public BacketMatch(String content)
    {
        this(new LinkedStack<Character>(), content, false);
    }
    public boolean isTrue()
    {
        boolean haveChara = false;
        boolean isOnePop = true;
        if(content != null && !charStack.equals(""))
        {
            for(char c : content.toCharArray())
            {
                if(c == '(')
                {
                    isOnePop = true;
                    if(haveChara && isHard)
                    {
                        return false;
                    }
                    charStack.push('(');
                }else  if(c == ')')
                {
                    if(isHard && isOnePop)
                    {
                        isOnePop = false;
                        haveChara = false;
                    } else if(isHard && !isOnePop && haveChara)
                    {
                        return false;
                    }
                    if(charStack.isEmpty())
                    {
                        return false;
                    }
                    charStack.pop();
                }else {
                    if(charStack.isEmpty())
                    {
                        return false; //如果是空的栈且还有元素，则false
                    }
                    haveChara = true;
                }
            }
            if(charStack.isEmpty())
            {
                return true;// 最终没有元素，则true
            }
        }
        return true;
    }
}
